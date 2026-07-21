import React from 'react';

const courses = [
  { id: 1, name: 'React Fundamentals',  duration: '4 weeks',  level: 'Beginner'     },
  { id: 2, name: 'Spring Boot Mastery', duration: '6 weeks',  level: 'Intermediate' },
  { id: 3, name: 'Microservices Architecture', duration: '8 weeks', level: 'Advanced' },
];

function CourseDetails() {
  return (
    <div>
      <h2>Course Details</h2>
      <table border="1" cellPadding="8" cellSpacing="0">
        <thead>
          <tr>
            <th>Course</th>
            <th>Duration</th>
            <th>Level</th>
          </tr>
        </thead>
        <tbody>
          {courses.map(course => (
            <tr key={course.id}>
              <td>{course.name}</td>
              <td>{course.duration}</td>
              <td>{course.level}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default CourseDetails;
