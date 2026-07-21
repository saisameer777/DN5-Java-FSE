import React, { Component } from 'react';

class Counter extends Component {
  constructor(props) {
    super(props);
    this.state = { count: 0 };
    this.increment = this.increment.bind(this);
    this.decrement = this.decrement.bind(this);
    this.sayHello  = this.sayHello.bind(this);
    this.sayWelcome = this.sayWelcome.bind(this);
  }

  increment() {
    this.setState({ count: this.state.count + 1 });
  }

  sayHello() {
    alert('Hello! Welcome to React Event Handling.');
  }

  decrement() {
    this.setState({ count: this.state.count - 1 });
  }

  sayWelcome(message) {
    alert(message);
  }

  handlePress(e) {
    alert('I was clicked');
  }

  render() {
    return (
      <div>
        <h2>Counter: {this.state.count}</h2>
        <button onClick={() => { this.increment(); this.sayHello(); }}>Increment</button>
        <button onClick={this.decrement}>Decrement</button>
        <br /><br />
        <button onClick={() => this.sayWelcome('welcome')}>Say Welcome</button>
        <br /><br />
        <button onMouseDown={this.handlePress}>OnPress</button>
      </div>
    );
  }
}

export default Counter;
