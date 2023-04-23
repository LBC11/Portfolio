import React, { useState, useEffect, useRef } from 'react';
import axiosInstance from './axiosInstance';
import { Line } from 'react-chartjs-2';
import { Chart, CategoryScale, LinearScale, TimeSeriesScale, LineController, LineElement, PointElement } from 'chart.js';
import { formatDate, renderDateRange } from './utils';
import './App.css';
import * as adapt from 'chartjs-adapter-date-fns';

Chart.register(adapt);
Chart.register(CategoryScale, LinearScale, TimeSeriesScale, LineController, LineElement, PointElement);

function App() {
  // State for selected section and personal data
  const [selectedSection, setSelectedSection] = useState('Personal Data');
  const [personalData, setPersonalData] = useState({
    educations: [],
    professionalAffiliations: [],
    projects: [],
    skillsAndTechniques: { skillCategories: [] },
    awardsAchievements: [],
    certifications: [],
    semesterGrades: []
  });

  // Chart reference
  const chartRef = useRef(null);

  // Fetch personal data on component mount
  useEffect(() => {
    axiosInstance.get('/api/personal-information/1')
      .then((response) => {
        setPersonalData(response.data);
      })
      .catch((error) => {
        console.error('Error fetching personal data:', error);
      });
  }, []);

  // Cleanup effect to destroy the chart
  useEffect(() => {
    const currentChartRef = chartRef.current;

    return () => {
      if (currentChartRef && currentChartRef.chartInstance) {
        currentChartRef.chartInstance.destroy();
      }
    };
  }, []);

  // Handle section button clicks
  const handleClick = (section) => {
    setSelectedSection(section);
  };

  // Render the content of the selected section
  const renderSection = () => {
    // Show loading message if data is not yet available
    if (!personalData || Object.keys(personalData).length === 0) {
      return <p>Loading data...</p>;
    }

    // Check if all required fields are available
    if (!personalData.name || !personalData.birth || !personalData.location || !personalData.nationality || !personalData.language) {
      return <p>Required data is missing. Please ensure all fields are present in the API response.</p>;
    }

    // Render content based on selected section
    switch (selectedSection) {
      case 'Personal Data':
        return (
          <div style={{ textAlign: 'left' }}>
            <img src={`${process.env.PUBLIC_URL}/Bob.jpg`} alt="Bob" style={{ width: '150px', height: 'auto', marginBottom: '1rem' }} />
            <p><strong>{personalData.name}</strong></p>
            <ul>
              <li>Birth: {formatDate(personalData.birth)}, in {personalData.location}</li>
              <li>Nationality: {personalData.nationality}</li>
              <li>Language: First language {personalData.language.split(',')[0]}, proficient in reading and writing in {personalData.language.split(',')[1].trim()}</li>
            </ul>
          </div>
        );
      case 'Education':
        const chartData = {
          labels: personalData.semesterGrades.map(grade => `${grade.year}-${grade.semester}`),
          datasets: [
            {
              label: 'GPA',
              data: personalData.semesterGrades.map(grade => grade.gpa),
              borderColor: 'rgba(75,192,192,1)',
              backgroundColor: 'rgba(75,192,192,0.2)',
            },
          ],
        };

        const chartOptions = {
          scales: {
            x: {
              type: 'category',
              title: {
                display: true,
                text: 'Semester',
                color: '#FFFFFF'
              },
              ticks: {
                callback: function (value, index, values) {
                  // Generate a tick value using the value of the index, such as label data.
                  return `${personalData.semesterGrades[index].year}-${personalData.semesterGrades[index].semester}`;
                },
                color: '#FFFFFF'
              },
              grid: {
                borderColor: '#FFFFFF'
              }
            },
            y: {
              title: {
                display: true,
                text: 'GPA',
                color: '#FFFFFF'
              },
              min: 3,
              max: 4.5,
              ticks: {
                stepSize: 0.5,
                color: '#FFFFFF'
              },
              grid: {
                borderColor: '#FFFFFF'
              }
            }
          }
        };

        return (
          <div style={{ textAlign: 'left' }}>
            {personalData.educations.map((education, index) => (
              <div key={education.id} className="section-item">
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start' }}>
                  <h3>{education.institution}</h3>
                  <h4 style={{ fontWeight: 'normal', marginLeft: '1rem' }}>
                    {renderDateRange(education.startDate, education.endDate)}
                  </h4>
                </div>
                <p style={{ fontStyle: 'italic' }}>{education.degree} {education.major}</p>
                {education.descriptions.map((description, i) => (
                  <p key={i} className="description-item">- {description}</p>
                ))}
                {index < personalData.educations.length - 1 && <hr />}
              </div>
            ))}

            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginTop: '2rem' }}>
              <div>
                <h3>Program Course</h3>
                <img src={`${process.env.PUBLIC_URL}/programCourse.png`} alt="Bob" style={{ width: '500px', height: 'auto', marginBottom: '2rem' }} />
              </div>

              <div style={{ width: '500px' }}>
                <h3>GPA</h3>
                <Line ref={chartRef} data={chartData} options={{ ...chartOptions, responsive: false }} />
              </div>
            </div>
          </div>
        );
      case 'Professional Affiliation':
        return (
          <div style={{ textAlign: 'left' }}>
            {personalData.professionalAffiliations.map((affiliation, index) => (
              <div key={affiliation.id} className="section-item">
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start' }}>
                  <h3>{affiliation.name}</h3>
                  <h4 style={{ fontWeight: 'normal', marginLeft: '1rem' }}>
                    {renderDateRange(affiliation.startDate, affiliation.endDate)}
                  </h4>
                </div>
                <p style={{ fontStyle: 'italic' }}>{affiliation.organization}</p>
                {affiliation.descriptions.map((description, i) => (
                  <p key={i} className="description-item">- {description}</p>
                ))}
                {index < personalData.professionalAffiliations.length - 1 && <hr />}
              </div>
            ))}
          </div>
        );
      case 'Projects':
        return (
          <div style={{ textAlign: 'left' }}>
            {personalData.projects.map((project, index) => (
              <div key={project.id} className="section-item">
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start' }}>
                  <h3>{project.name}</h3>
                  <h4 style={{ fontWeight: 'normal', marginLeft: '1rem' }}>
                    {renderDateRange(project.startDate, project.endDate)}
                  </h4>
                </div>
                {project.descriptions.map((description, i) => (
                  <p key={i} className="description-item">- {description}</p>
                ))}

                {/* Add images at the end of the project */}
                {project.id === 1 && (
                  <div style={{ display: 'flex', justifyContent: 'space-between', marginTop: '1rem' }}>
                    <img src={`${process.env.PUBLIC_URL}/todoMap1.png`} alt="Todo Map 1" style={{ maxWidth: '49%' }} />
                    <img src={`${process.env.PUBLIC_URL}/todoMap2.png`} alt="Todo Map 2" style={{ maxWidth: '49%' }} />
                  </div>
                )}

                {project.id === 2 && (
                  <div style={{ display: 'flex', justifyContent: 'space-between', marginTop: '1rem' }}>
                    <img src={`${process.env.PUBLIC_URL}/itmWiki1.png`} alt="ITM Wiki 1" style={{ maxWidth: '49%' }} />
                    <img src={`${process.env.PUBLIC_URL}/itmWiki2.png`} alt="ITM Wiki 2" style={{ maxWidth: '49%' }} />
                  </div>
                )}

                {project.id === 3 && (
                  <div style={{ display: 'flex', justifyContent: 'space-between', marginTop: '1rem' }}>
                    <img src={`${process.env.PUBLIC_URL}/verifyNegativityBias1.png`} alt="Verify Negativity Bias 1" style={{ maxWidth: '49%' }} />
                    <img src={`${process.env.PUBLIC_URL}/verifyNegativityBias2.png`} alt="Verify Negativity Bias 2" style={{ maxWidth: '49%' }} />
                  </div>
                )}
                {index < personalData.projects.length - 1 && <hr />}
              </div>
            ))}
          </div>
        );
      case 'Skills and Techniques':
        return (
          <div style={{ textAlign: 'left' }}>
            {personalData.skillsAndTechniques.skillCategories.map((category, index) => (
              <div key={category.id} className="section-item">
                <p style={{ marginBottom: '0.5rem' }}><strong>• {category.name}</strong></p>
                <p style={{ marginLeft: '1rem' }}>| {category.skills.map((skill) => skill.name).join(' | ')} |</p>
              </div>
            ))}
          </div>
        );
      case 'Awards & Achievements':
        return (
          <div style={{ textAlign: 'left' }}>
            {personalData.awardsAchievements.map((award, index) => (
              <div key={award.id} className="section-item">
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                  <span style={{ marginRight: '1rem' }}><strong>{award.name}</strong> ({award.description})</span>
                  <span>{formatDate(award.dateReceived)}</span>
                </div>
              </div>
            ))}
          </div>
        );
      case 'Certifications':
        return (
          <div style={{ textAlign: 'left' }}>
            {personalData.certifications.map((certification, index) => (
              <div key={certification.id} className="section-item">
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                  <span style={{ marginRight: '1rem' }}><strong>{certification.name}</strong> - {certification.description}</span>
                  <span>{formatDate(certification.dateReceived)}</span>
                </div>
              </div>
            ))}
          </div>
        );
      default:
        return null;
    }
  };

  return (
    <div className="App">
      <header className="App-header" style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
        <img src={process.env.PUBLIC_URL + '/intelLogo.png'} alt="Intel Logo" style={{ width: '100px', height: 'auto' }} />
        <h1>Portfolio</h1>
        <div style={{ width: '100px' }}></div>
      </header>

      {/* Main content */}
      <main>
        <div className="content">

          {/* Left panel with section buttons */}
          <div className="left-panel">
            {[
              'Personal Data',
              'Education',
              'Professional Affiliation',
              'Projects',
              'Skills and Techniques',
              'Awards & Achievements',
              'Certifications',
            ].map((section) => (
              <button
                key={section}
                className="section-button"
                onClick={() => handleClick(section)}
              >
                {section}
              </button>
            ))}
          </div>

          {/* Right panel with section content */}
          <div className="right-panel">
            <section>
              {renderSection()}
            </section>
          </div>
        </div>
      </main>

      {/* Footer with contact information */}
      <footer>
        <h3>Contact Me</h3>
        <p>Email: <a href="mailto:18102085@seoultech.ac.kr">18102085@seoultech.ac.kr</a>, <a href="mailto:wpdltm4@gmail.com">wpdltm4@gmail.com</a></p>
        <p>GitHub: <a href="https://github.com/LBC11" target="_blank" rel="noopener noreferrer">https://github.com/LBC11</a></p>
        <p>Cell phone: 010-4758-8763</p>
      </footer>
    </div>
  );
}

export default App;
