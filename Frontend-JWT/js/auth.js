$(document).ready(function() {
  // Check which form is present and attach the appropriate handler
  if ($('#registrationForm').length) {
    // Handle registration form submission
    $('#registrationForm').submit(function(event) {
      event.preventDefault(); // Prevent default form submission
      userRegistration(); // Call the registration function
    });
  }

  if ($('#loginForm').length) {
    // Handle login form submission
    $('#loginForm').submit(function(event) {
      event.preventDefault(); // Prevent default form submission
      userLogin(); // Call the login function
    });
  }
});

function userRegistration() {
  // Define variables
  let name = $('#name').val();
  let email = $('#email').val();
  let password = $('#password').val();

  // Create AJAX request
  $.ajax({
    url: 'http://localhost:8080/api/v1/auth/register',
    method: 'POST',
    contentType: 'application/json',
    data: JSON.stringify({
      name: name,
      email: email,
      password: password
    }),

    success: function(response) {
      console.log(response);
      alert('Registration successful!');
      // Optionally redirect or clear the form here
      window.location.href = '/Sign-in.html'; // Redirect to login after registration
    },

    error: function(error) {
      console.log(error);
      alert('Registration failed. Please try again.');
    }
  });
}

function userLogin() {
  // Define variables
  let email = $('#email').val();
  let password = $('#password').val();

  // Create AJAX request
  $.ajax({
    url: 'http://localhost:8080/api/v1/auth/authenticate',
    method: 'POST',
    contentType: 'application/json',
    data: JSON.stringify({
      email: email,
      password: password
    }),

    success: function(response) {
      console.log(response);
      alert('Login successful!');
      localStorage.setItem('token', response.data.token)
      // Optionally redirect to another page
      window.location.href = '/JWT-Authentication/Frontend-JWT/dashboard.html'; // Redirect to a dashboard or homepage
    },

    error: function(error) {
      console.log(error);
      alert('Login failed. Please check your credentials and try again.');
    }
  });
}
