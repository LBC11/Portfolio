import React, { useState } from 'react';
import './App.css';

function App() {
  const [selectedSection, setSelectedSection] = useState('Personal Data');

  const handleClick = (section) => {
    setSelectedSection(section);
  };

  const renderSection = () => {
    switch (selectedSection) {
      case 'Personal Data':
        return (
          <p>
            Born in the Republic of Korea in 1998, Byungchan Lee, also known as Bob, is a passionate Information Technology and Management student at Seoul National University of Science and Technology. Fluent in Korean and proficient in English, Bob is dedicated to furthering his skills in the IT field.
          </p>
        );
      case 'Education':
        return (
          <ul>
            <li>Seoul National University of Science and Technology, Bachelor of Information Technology and Management</li>
            <li>Northumbria University, Information Technology Management for Business BSc(Hons) - Dual Degree</li>
          </ul>
        );
      case 'Professional Affiliation':
        return (
          <p>
            {/* 여기에 Professional Affiliation 내용을 작성하세요 */}
          </p>
        );
      case 'Projects':
        return (
          <ul>
            <li>User-Location based To-do list Android Application</li>
            <li>ITM Study Resource Sharing Platform (itmWiki)</li>
            <li>Twitter Data-based Negativity Bias Verification Web Service</li>
          </ul>
        );
      case 'SKILLS AND TECHNIQUES':
        return (
          <ul>
            <li>Business Analysis/Solution Design Skills</li>
            <li>Programming Languages/Frameworks</li>
            <li>Tools</li>
          </ul>
        );
      case 'AWARDS & ACHIEVEMENTS':
        return (
          <ul>
            <li>Silver Prize in Finance - Fintech Intellectual Property Online Quiz Competition (Dec. 2022)</li>
            <li>Encouragement Award - University Coding Competition (Nov. 2022)</li>
            <li>Silver Prize in Domestic Category - Global Challenger Competition (Oct. 2021)</li>
          </ul>
        );
      case 'Certification':
        return (
          <p>
            {/* 여기에 Certification 내용을 작성하세요 */}
          </p>
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
              'SKILLS AND TECHNIQUES',
              'AWARDS & ACHIEVEMENTS',
              'Certification',
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
              <h2>{selectedSection}</h2>
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