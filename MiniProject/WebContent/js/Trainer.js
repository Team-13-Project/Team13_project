function Trainer(_fullName, _emailId, _yearlyTarget, _currentAge) {
	this.trainerId = 0;
    this.fullName = _fullName;
    this.emailId = _emailId;
    this.yearlyTarget = _yearlyTarget;
    this.age = _currentAge;
}

function SearchTrainer(_searchType, _value) {
    this.searchType = _searchType;
    this.value = _value
}