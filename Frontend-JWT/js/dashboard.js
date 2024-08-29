$(document).ready(function() {
  let token = localStorage.getItem('token');
  if (token) {
    $.ajax({
      url: 'http://localhost:8080/api/v1/blog/newMethod',
      method: 'GET',
      contentType: 'application/json',
      headers: {
        'Authorization': 'Bearer ' + token
      },

      success: function (response) {
        console.log(response);
        $("#hello").append(response)
          alert("The response is : " + response);
      },

      error: function (error) {
        console.log(error);
      }
    });
  }else {
    window.location.href = 'Sign-in.html';
  }
});

function logOut() {
  // Remove the token from local storage
  localStorage.removeItem('token')
  // Redirect to the login page after logout
  window.location.href = "Sign-in.html";
}
