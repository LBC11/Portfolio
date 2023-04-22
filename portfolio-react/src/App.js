import React, { useState, useEffect } from 'react';
import axiosInstance from './axiosInstance';
import './App.css';

function App() {
  const [selectedSection, setSelectedSection] = useState('Personal Data');
  const [personalData, setPersonalData] = useState({
    educations: [],
    professionalAffiliations: [],
    projects: [],
    skillsAndTechniques: { skillCategories: [] },
    awardsAchievements: [],
    certifications: []
  });

  useEffect(() => {
    axiosInstance.get('/api/personal-information/1')
      .then((response) => {
        setPersonalData(response.data);
      })
      .catch((error) => {
        console.error('Error fetching personal data:', error);
      });
  }, []);

  const handleClick = (section) => {
    setSelectedSection(section);
  };

  const renderSection = () => {
    if (!personalData || Object.keys(personalData).length === 0) {
      return <p>Loading data...</p>;
    }

    switch (selectedSection) {
      case 'Personal Data':
        if (!personalData.name) {
          return <p>Loading data...</p>;
        }
        return (
          <p>
            Born in {personalData.location} in {new Date(personalData.birth).getFullYear()}, {personalData.name}, is a passionate {personalData.degree} student at {personalData.university}. Fluent in {personalData.language}, {personalData.name.split(' ')[0]} is dedicated to furthering their skills in the IT field.
          </p>
        );
      case 'Education':
        return (
          <ul>
            {personalData.educations.map((education) => (
              <li key={education.id}>
                {education.institution}, {education.degree} {new Date(education.startDate).getFullYear()}-{("0" + (new Date(education.startDate).getMonth() + 1)).slice(-2)} ~ <br />
                Description: {education.descriptions.join(', ')}
              </li>
            ))}
          </ul>
        );
      case 'Professional Affiliation':
        return (
          <ul>
            {personalData.professionalAffiliations.map((affiliation) => (
              <li key={affiliation.id}>
                {affiliation.name} ({affiliation.organization})<br />
                Description: {affiliation.descriptions.join(', ')}<br />
                Dates: {new Date(affiliation.startDate).getFullYear()}-{("0" + (new Date(affiliation.startDate).getMonth() + 1)).slice(-2)} ~ {new Date(affiliation.endDate).getFullYear()}-{("0" + (new Date(affiliation.endDate).getMonth() + 1)).slice(-2)}
              </li>
            ))}
          </ul>
        );
      case 'Projects':
        return (
          <ul>
            {personalData.projects.map((project) => (
              <li key={project.id}>
                {project.name} - {project.descriptions.join(', ')}<br />
                Date: {new Date(project.startDate).getFullYear()}-{("0" + (new Date(project.startDate).getMonth() + 1)).slice(-2)} ~ {new Date(project.endDate).getFullYear()}-{("0" + (new Date(project.endDate).getMonth() + 1)).slice(-2)}
              </li>
            ))}
          </ul>
        );
      case 'Skills and Techniques':
        return (
          <div>
            {personalData.skillsAndTechniques.skillCategories.map((category) => (
              <div key={category.id}>
                <h3>{category.name}</h3>
                <ul>
                  {category.skills.map((skill) => (
                    <li key={skill.id}>{skill.name}</li>
                  ))}
                </ul>
              </div>
            ))}
          </div>
        );
      case 'Awards & Achievements':
        return (
          <ul>
            {personalData.awardsAchievements.map((award) => (
              <li key={award.id}>
                {award.name} ({award.description})<br />
                Date Received: {new Date(award.dateReceived).getFullYear()}-{("0" + (new Date(award.dateReceived).getMonth() + 1)).slice(-2)}
              </li>
            ))}
          </ul>
        );
      case 'Certifications':
        return (
          <ul>
            {personalData.certifications.map((certification) => (
              <li key={certification.id}>{certification.name}<br />
              Description: {certification.description}<br />
              Date: {new Date(certification.dateReceived).getFullYear()}-{("0" + (new Date(certification.dateReceived).getMonth() + 1)).slice(-2)}
              </li>
            ))}
          </ul>
        );
      default:
        return null;
    }
  };

  return (
    <div className="App">
      <header className="App-header">
        <h1>Byungchan Lee (Bob) - Portfolio</h1>
      </header>
      <main>
        <div className="content">
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
          <div className="right-panel">
            <section>
              {/* <h2>{selectedSection}</h2> */}
              {renderSection()}
            </section>
          </div>
        </div>
      </main>
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
