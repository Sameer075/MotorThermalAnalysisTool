let token = localStorage.getItem('myValue');
if(token===null){
	window.location.href = '/authenticate'; 
}
else{
function submitForm() {
	console.log(token);
	var nameValue = document.getElementById("deviceType").value;
	var descriptionValue = document.getElementById("deviceDiscr").value;
	var tempValue = document.getElementById("temp").value;

	var requestBody = {
		deviceType: nameValue,
		deviceDiscr: descriptionValue,
		threshold: [{
			temp: tempValue
		}]
	};

	fetch('/device', {
		method: 'POST',


		headers: {
			'Authorization': 'Bearer ' + token,
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(requestBody)
	})
		.then(response => {
			if (response.ok) {
				// Save the successful POST request
				console.log("POST request saved successfully!");
				return response.json();
			} else {
				throw new Error('Error: ' + response.status);
			}
		})
		.then(data => {
			// Handle the response data
			console.log(data);

		})
		.catch(error => {
			// Handle errors
			console.error(error);
		});
}

let form = document.getElementById("f");

function myFunction() {
	if (form.checkValidity()) {
		alert("Adding Succesful!");

	}
}
form.addEventListener("submit", function(e) {
	e.preventDefault();
}, false);
function logout() {
  // Remove the token from localStorage
  localStorage.removeItem('myValue');

  // Redirect to the login page or perform any other desired action
  window.location.href = '/authenticate'; // Replace '/authenticate' with the appropriate login page URL
}
}

