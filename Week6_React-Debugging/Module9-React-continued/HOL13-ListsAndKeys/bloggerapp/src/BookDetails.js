import React from 'react';

const books = [
  { id: 1, title: 'Clean Code',        author: 'Robert C. Martin', year: 2008 },
  { id: 2, title: 'The Pragmatic Programmer', author: 'David Thomas', year: 1999 },
  { id: 3, title: 'Design Patterns',   author: 'Gang of Four',      year: 1994 },
];

function BookDetails() {
  return (
    <div>
      <h2>Book Details</h2>
      <ul>
        {books.map(book => (
          <li key={book.id}>
            <strong>{book.title}</strong> by {book.author} ({book.year})
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BookDetails;
