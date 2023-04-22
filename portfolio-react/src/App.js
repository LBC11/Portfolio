import React, { useState, useEffect } from 'react';
import axiosInstance from './axiosInstance';
import './App.css';

function App() {
  // State for selected section and personal data
  const [selectedSection, setSelectedSection] = useState('Personal Data');
  const [personalData, setPersonalData] = useState({
    educations: [],
    professionalAffiliations: [],
    projects: [],
    skillsAndTechniques: { skillCategories: [] },
    awardsAchievements: [],
    certifications: []
  });

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

    // Render content based on selected section
    switch (selectedSection) {
      case 'Personal Data':
        return (
          <div style={{ textAlign: 'left' }}>
            <p><strong>{personalData.name}</strong></p>
            <ul>
              <li>Birth: {new Date(personalData.birth).getFullYear()}.{("0" + (new Date(personalData.birth).getMonth() + 1)).slice(-2)}.{("0" + (new Date(personalData.birth).getDate())).slice(-2)}, in {personalData.location}</li>
              <li>Nationality: {personalData.nationality}</li>
              <li>Language: First language {personalData.language.split(',')[0]}, proficient in reading and writing in {personalData.language.split(',')[1].trim()}</li>
            </ul>
          </div>
        );
      case 'Education':
        return (
          <div style={{ textAlign: 'left' }}>
            {personalData.educations.map((education, index) => (
              <div key={education.id} style={{ marginBottom: index < personalData.educations.length - 1 ? '1rem' : '0' }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start' }}>
                  <h3>{education.institution}</h3>
                  <h4 style={{ fontWeight: 'normal', marginLeft: '1rem' }}>
                    {new Date(education.startDate).toLocaleDateString()} ~{' '}
                    {education.endDate ? new Date(education.endDate).toLocaleDateString() : 'Present'}
                  </h4>
                </div>
                <p style={{ fontStyle: 'italic' }}>{education.degree} {education.major}</p>
                {education.descriptions.map((description, i) => (
                  <p key={i} style={{ marginTop: i === 0 ? 0 : '0.5rem', marginBottom: '0.5rem' }}>- {description}</p>
                ))}
                {index < personalData.educations.length - 1 && <hr />}
              </div>
            ))}
          </div>
        );
      case 'Professional Affiliation':
        return (
          <div style={{ textAlign: 'left' }}>
            {personalData.professionalAffiliations.map((affiliation, index) => (
              <div key={affiliation.id} style={{ marginBottom: index < personalData.professionalAffiliations.length - 1 ? '1rem' : '0' }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start' }}>
                  <h3>{affiliation.name}</h3>
                  <h4 style={{ fontWeight: 'normal', marginLeft: '1rem' }}>
                    {new Date(affiliation.startDate).getFullYear()}-{("0" + (new Date(affiliation.startDate).getMonth() + 1)).slice(-2)}  ~{' '}
                    {new Date(affiliation.endDate).getFullYear()}-{("0" + (new Date(affiliation.endDate).getMonth() + 1)).slice(-2)}
                  </h4>
                </div>
                <p style={{ fontStyle: 'italic' }}>{affiliation.organization}</p>
                {affiliation.descriptions.map((description, i) => (
                  <p key={i} style={{ marginTop: i === 0 ? 0 : '0.5rem', marginBottom: '0.5rem' }}>- {description}</p>
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
              <div key={project.id} style={{ marginBottom: index < personalData.projects.length - 1 ? '1rem' : '0' }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start' }}>
                  <h3>{project.name}</h3>
                  <h4 style={{ fontWeight: 'normal', marginLeft: '1rem' }}>
                    {new Date(project.startDate).getFullYear()}-{("0" + (new Date(project.startDate).getMonth() + 1)).slice(-2)}  ~{' '}
                    {new Date(project.endDate).getFullYear()}-{("0" + (new Date(project.endDate).getMonth() + 1)).slice(-2)}
                  </h4>
                </div>
                {project.descriptions.map((description, i) => (
                  <p key={i} style={{ marginTop: i === 0 ? 0 : '0.5rem', marginBottom: '0.5rem' }}>- {description}</p>
                ))}
                {index < personalData.projects.length - 1 && <hr />}
              </div>
            ))}
          </div>
        );
      case 'Skills and Techniques':
        return (
          <div style={{ textAlign: 'left' }}>
            {personalData.skillsAndTechniques.skillCategories.map((category, index) => (
              <div key={category.id} style={{ marginBottom: index < personalData.skillsAndTechniques.skillCategories.length - 1 ? '1rem' : '0' }}>
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
              <div key={award.id} style={{ marginBottom: index < personalData.awardsAchievements.length - 1 ? '1rem' : '0' }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                  <span style={{ marginRight: '1rem' }}><strong>{award.name}</strong> ({award.description})</span>
                  <span>{new Date(award.dateReceived).getFullYear()}-{("0" + (new Date(award.dateReceived).getMonth() + 1)).slice(-2)}-{("0" + new Date(award.dateReceived).getDate()).slice(-2)}</span>
                </div>
              </div>
            ))}
          </div>
        );
      case 'Certifications':
        return (
          <div style={{ textAlign: 'left' }}>
            {personalData.certifications.map((certification, index) => (
              <div key={certification.id} style={{ marginBottom: index < personalData.certifications.length - 1 ? '1rem' : '0' }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                  <span style={{ marginRight: '1rem' }}><strong>{certification.name}</strong> - {certification.description}</span>
                  <span>{new Date(certification.dateReceived).getFullYear()}-{("0" + (new Date(certification.dateReceived).getMonth() + 1)).slice(-2)}</span>
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
        <img src={process.env.PUBLIC_URL + '/intel_logo.png'} alt="Intel Logo" style={{ width: '100px', height: 'auto' }} />
        <h1>Byungchan Lee (Bob) - Portfolio</h1>
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
