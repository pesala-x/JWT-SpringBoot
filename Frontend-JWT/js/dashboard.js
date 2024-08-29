$(document).ready(function() {
  let token = localStorage.getItem('token');
  if (!token) {
    window.location.href = 'Sign-in.html';
  }
});

function logOut() {
  // Remove the token from local storage
  localStorage.removeItem('token')

  // Redirect to the login page after logout
  window.location.href = "Sign-in.html";
}
