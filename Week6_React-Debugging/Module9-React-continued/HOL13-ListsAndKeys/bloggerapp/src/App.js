import React, { Component } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { activeTab: 'books' };
  }

  render() {
    const { activeTab } = this.state;

    let content;
    if (activeTab === 'books') {
      content = <BookDetails />;
    } else if (activeTab === 'blogs') {
      content = <BlogDetails />;
    } else {
      content = <CourseDetails />;
    }

    return (
      <div>
        <h1>Blogger App</h1>
        <button onClick={() => this.setState({ activeTab: 'books'   })}>Books</button>
        <button onClick={() => this.setState({ activeTab: 'blogs'   })}>Blogs</button>
        <button onClick={() => this.setState({ activeTab: 'courses' })}>Courses</button>
        <hr />
        {content}
      </div>
    );
  }
}

export default App;
