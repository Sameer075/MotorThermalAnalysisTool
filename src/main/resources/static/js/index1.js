/**
 * 
 */
var token;
function login() {
	console.log(token);
	var uname = document.getElementById("name").value;
	var password = document.getElementById("pass").value;


	var requestBody = {
		username: uname,
		password: password,

	};
	fetch('/authenticate', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(requestBody)
	})
		.then(response => {
			if (response.ok) {
				// Save the successful POST request
				return response.json();
			} else {
				invalidFunction();
				throw new Error('Error: ' + response.status);
				
			}
		})
		.then(data => {
			// Handle the response data
			token = data.token;
			localStorage.setItem('myValue', token);
			loginFunction();

		})
		.catch(error => {
			// Handle errors
			console.error(error);
		});
}

let form1 = document.getElementById("l");

function loginFunction() {
	if (form1.checkValidity()) {
		alert("Login Succesful!");
		
	}
}
function invalidFunction(){
	alert("Envalid Credential");
}
form1.addEventListener("submit", function(e) {
	e.preventDefault();
}, false);
function logout() {
  // Remove the token from localStorage
  localStorage.removeItem('myValue');

  // Redirect to the login page or perform any other desired action
  window.location.href = '/authenticate'; // Replace '/authenticate' with the appropriate login page URL
}