
function extractAddEducationForm(jsonArray) {
	// Converting str json to javascript json
	let arr = JSON.parse(jsonArray);
    
    // Capturing form data fields into array
	let fields = [];
	for(let i in arr) {
		fields.push(arr[i].value);
	}

    // Creating education object
	let education = new Education(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], fields[7], fields[8], fields[9], fields[10]);
    
    // Logging extracted education details
    console.log("Form data converted to Education object with details : ");
    console.log(education.educationId + " " + education.instituteName + " " + education.degree + " " + education.specialization + " " + education.startYear+ " " + education.endYear + " " + education.courseDuration + " " + education.board+ " " + education.percentage + " " + education.city + " " + education.state + " " + education.country);
    
    return education;
}

//function extractSearchEducationForm(jsonArray) {
//    // Converting str with "" to javascript 
//    let arr = JSON.parse(jsonArray);
//    console.log("string input with \"");
//    console.log(arr)
//
//    // Convert arr to valid array javascript object
//    arr = JSON.parse(arr);
//    console.log(arr);
//    
//    // Capturing form data fields into array
//    let fields = [];
//    for(let i in arr) {
//        fields.push(arr[i].value);
//	}
//	
//    // Creating Search pattern object
//	let searchObj = new SearchEducation(fields[0], fields[1]);
//    
//    // Logging search education details
//    console.log("Search Criteria : " + searchObj.searchType + " -> " + searchObj.value);
//    
//    return searchObj;
//}