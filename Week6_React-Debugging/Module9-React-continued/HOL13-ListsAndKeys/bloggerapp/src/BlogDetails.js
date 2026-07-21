import React from 'react';

const blogs = [
  { id: 1, title: 'Getting Started with React', date: '01-Jan-2024', category: 'React' },
  { id: 2, title: 'Understanding Spring Boot',  date: '15-Feb-2024', category: 'Java'  },
  { id: 3, title: 'Microservices Best Practices', date: '10-Mar-2024', category: 'Architecture' },
];

function BlogDetails() {
  return (
    <div>
      <h2>Blog Details</h2>
      {blogs.map(blog => (
        <div key={blog.id} style={{ border: '1px solid #ddd', margin: '8px', padding: '8px' }}>
          <h4>{blog.title}</h4>
          <p>Category: {blog.category} | Date: {blog.date}</p>
        </div>
      ))}
    </div>
  );
}

export default BlogDetails;
