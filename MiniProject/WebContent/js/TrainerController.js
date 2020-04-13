$(function () {
    
    // When clicking on Add Trainer menu link load this page
    $('#addTrainerPage').click(function(){
        $('#add_Trainer_Form').html('');
        $('#add_Trainer_Form').load('addTrainer.html');
    });

    // When clicking on Search Trainer menu link load this page
    $('#searchTrainerPage').click(function(){
        $('#add_Trainer_Container').html('');
        $('#add_Trainer_Container').load('searchTrainer.html');
    });
    
    // When clicking on View Trainer menu link load this page
    $('#viewTrainerPage').click(function(){
        $('#add_Trainer_Container').html('');
        $('#add_Trainer_Container').load('viewTrainers.html');
    });
    

    // Handle add event when add trainer form is submitted
    $('#add_trainer_submit').click(function(){

        // Get form data using jquery
        let addFormData = $("#add_Trainer_Form").serializeArray();
        console.log('Got add trainer request in TrainerController : ' + addFormData);

        // Convert form data into valid json string
        let trainerStr = JSON.stringify(addFormData);

        // Convert json string into javascript object
        let trainer = extractAddTrainerForm(trainerStr);

        // Make call to service to store data
        addTrainer(trainer);
    });

    // Handle search event when search trainer form is submitted
    $('#search_trainer_submit').click(function(){
        // Get form data using jquery
        let searchFormData = JSON.stringify($("#search_Trainer_Form").serializeArray());

        // Convert form data into valid json string
        let searchStr = JSON.stringify(searchFormData);

        // Convert json string into javascript object
        let searchTrainerObj = extractSearchTrainerForm(searchStr);
        console.log('Got search trainer request in TrainerController : ' + searchTrainerObj)

        // Make call to service to search trainer
        searchTrainerDetails(searchTrainerObj);
    });

    // $('#update-trainer').click(function(){
    //     edittrainerDetails = JSON.stringify($("#edit_Trainer_Form").serializeArray());
    //     localStorage.setItem('EdittrainerDetails',edittrainerDetails);       
    //     console.log(edittrainerDetails);
    // });


});
