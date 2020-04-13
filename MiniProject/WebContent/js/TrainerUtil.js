
function extractAddTrainerForm(jsonArray) {
	// Converting str json to javascript json
	let arr = JSON.parse(jsonArray);
    
    // Capturing form data fields into array
	let fields = [];
	for(let i in arr) {
		fields.push(arr[i].value);
	}

    // Creating trainer object
	let trainer = new Trainer(fields[0], fields[1], fields[2], fields[3]);
    
    // Logging extracted trainer details
    console.log("Form data converted to Trainer object with details : ");
    console.log(trainer.trainerId + " " + trainer.fullName + " " + trainer.emailId + " " + trainer.yearlyTarget + " " + trainer.currentAge);
    
    return trainer;
}

function extractSearchTrainerForm(jsonArray) {
    // Converting str with "" to javascript 
    let arr = JSON.parse(jsonArray);
    console.log("string input with \"");
    console.log(arr)

    // Convert arr to valid array javascript object
    arr = JSON.parse(arr);
    console.log(arr);
    
    // Capturing form data fields into array
    let fields = [];
    for(let i in arr) {
        fields.push(arr[i].value);
	}
	
    // Creating Search pattern object
	let searchObj = new SearchTrainer(fields[0], fields[1]);
    
    // Logging search trainer details
    console.log("Search Criteria : " + searchObj.searchType + " -> " + searchObj.value);
    
    return searchObj;
}