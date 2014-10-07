app.controller("MainController", ['$scope','$http', function($scope,$http){
	
	var error = true;
	var errorMessage = "";
	
	$http.get('webservers').success(function(data) {
	       $scope.webservers = data;
	    });
	    	
    $scope.showDetails = function(webserver) {
    	$http.get('webservers/' + webserver).success(function(data) {
 	       console.log(data);
 	    }).error(function(response){
 	    	console.log(response);
 	    	$scope.error = true;
 	    	$scope.errorMessage = response;
 	    });

    }
}]);