function addTrainer(obj) {
    console.log('Got add trainer request in TrainerService : ' + obj)
	
	// Make ajax call to save trainer
	ajaxStoreTrainer(obj);
}

function searchTrainerDetails(obj) {
    console.log('Got search trainer request in TrainerService : ' + obj)
	
	// Make ajax call to search a trainer
	ajaxSearchTrainer(obj);	
}

function ajaxSearchTrainer(obj){
	console.log('Sending search type : ' + obj.searchType + " with value : " + obj.value);
	let methodType = "GET"; // Get data from server
	let url = "http://localhost:8082/MiniProject/rest/trainers/";

	if(obj.searchType == 'trainerId') {
		url += "id/"+obj.value;
	}
	else if(obj.searchType == 'emailId') {
		url += "email/"+obj.value;
	}
	// Create XMLHttpRequest object
	let xhttp = new XMLHttpRequest();

	// Check with Server readiness to call and fetch the data
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			json = this.responseText;
			json = JSON.parse(json); 
			console.log('Json response from Server');
			console.log(json);
		}
	}

	// Open the Request
	xhttp.open(methodType, url, true);
	
	xhttp.setRequestHeader("Content-type", "text/plain");
	xhttp.send();
}

function ajaxStoreTrainer(trainer) {
	console.log('Making ajax call to store Trainer calling Server');

	// Convert json object to string before making ajax request
	trainer = JSON.stringify(trainer);
	console.log(trainer);

    let methodType = "POST"; // Post request is used to add a record to Server
	let url = "http://localhost:8082/MiniProject/rest/trainers/";

	// Create XMLHttpRequest object
	let xhttp = new XMLHttpRequest();

	// Check with Server readiness to call and fetch the data
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
            let jsonResponse = this.responseText;
            console.log('Json response from Server');
            console.log(jsonResponse)
//			  json = JSON.parse(json); document.write(json.users);
		}
	}
	// Open the Request
	xhttp.open(methodType, url, true);

	xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
	xhttp.send(trainer);
}