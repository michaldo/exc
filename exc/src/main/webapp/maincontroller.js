app.controller("MainController", [ '$scope', '$http', function($scope, $http) {

	$scope.alerts = [ ];
	
	$scope.addAlert = function(msg) {
		$scope.alerts.push({
			type : 'danger',
			msg : msg
		});
	};

	$scope.closeAlert = function(index) {
		$scope.alerts.splice(index, 1);
	};

	var error = true;
	var errorMessage = "";

	$http.get('webservers').success(function(data) {
		$scope.webservers = data;
	});
	
	$http.get('databases').success(function(data) {
		$scope.databases = data;
	});

	
	$scope.showWebserver = function(name) {
		$scope.showDetails('webservers/' + name);
	}
	
	$scope.showDatabase = function(name) {
		$scope.showDetails('databases/' + name);
	}


	$scope.showDetails = function(url) {
		$http.get(url).success(function(data) {
			console.log(data);
			$scope.details = data;
		}).error(function(response) {
			console.log(response);
			$scope.addAlert(response);
		});

	}
} ]);