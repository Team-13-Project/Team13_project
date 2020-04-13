$(function () {
    
    // When clicking on Add education menu link load this page
    $('#addEducationPage').click(function(){
        $('#add_Education_Form').html('');
        $('#add_Education_Form').load('addEducation.html');
    });

    // When clicking on Search education menu link load this page
    $('#viewEducationPage').click(function(){
        $('#add_Education_Container').html('');
        $('#add_Education_Container').load('viewEducation.html');
    });
    

    // Handle add event when add education form is submitted
    $('#add_education_submit').click(function(){

        // Get form data using jquery
        let addFormData = $("#add_Education_Form").serializeArray();
        console.log('Got add Education request in EducationController : ' + addFormData);

        // Convert form data into valid json string
        let educationStr = JSON.stringify(addFormData);
        console.log(educationStr);

        // Convert json string into javascript object
        let education = extractAddEducationForm(educationStr);
        console.log('hi');
        
        // Make call to service to store data
        addEducation(education);
    });

    // Handle search event when search education form is submitted
    $('#search_education_submit').click(function(){
        // Get form data using jquery
        let searchFormData = JSON.stringify($("#search_Education_Form").serializeArray());

        // Convert form data into valid json string
        let searchStr = JSON.stringify(searchFormData);

        // Convert json string into javascript object
        let searchEducationObj = extractSearchEducationForm(searchStr);
        console.log('Got search Education request in EducationController : ' + searchEducationObj)

        // Make call to service to search education
        searchEducationDetails(searchEducationObj);
    });

     $('#update-education').click(function(){
         editeducationDetails = JSON.stringify($("#edit_Education_Form").serializeArray());
         localStorage.setItem('EditeducationDetails',editeducationDetails);       
         console.log(editeducationDetails);
     });


});
