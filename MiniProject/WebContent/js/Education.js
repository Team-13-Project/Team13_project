function Education(_instituteName, _degree, _specialization, _startYear, _endYear,
		_courseDuration, _board, _percentage, _city, _state, _country) {
	
	this.educationId = 0;
    this.instituteName = _instituteName;
    this.degree = _degree;
    this.specialization = _specialization;
    this.startYear = _startYear;
    
    this.endYear = _endYear;
    this.courseDuration = _courseDuration;
    this.board = _board;
    this.percentage = _percentage;
    
    this.city = _city;
    this.state = _state;
    this.country = _country;
}

function SearchEducation(_searchType, _value) {
    this.searchType = _searchType;
    this.value = _value
}