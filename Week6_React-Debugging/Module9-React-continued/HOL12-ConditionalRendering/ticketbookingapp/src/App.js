import React, { Component } from 'react';
import GuestPage from './GuestPage';
import UserPage from './UserPage';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { isLoggedIn: false };
    this.handleLogin  = this.handleLogin.bind(this);
    this.handleLogout = this.handleLogout.bind(this);
  }

  handleLogin() {
    this.setState({ isLoggedIn: true });
  }

  handleLogout() {
    this.setState({ isLoggedIn: false });
  }

  render() {
    return (
      <div>
        <h1>Ticket Booking App</h1>
        {this.state.isLoggedIn
          ? <UserPage onLogout={this.handleLogout} />
          : <GuestPage onLogin={this.handleLogin} />
        }
      </div>
    );
  }
}

export default App;
