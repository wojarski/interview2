(function () {
    //"use strict";
    if (typeof angular === "undefined") {
        alert("Error! No angular library!");
        return;
    }
    var interviewApp = angular.module('interview', []);

    
    interviewApp.directive("transfer", function() {
    	var transferController = function($scope) {
    		$scope.submitTransfer = function(form) {
    			$.ajax({
    				method: "post",
    				url: "/",
    				data: $scope.data,
    				success: function(data) {
    					if(data.errors) {
    						$.each(data.errors, function(key, val) {
    							if($scope.form[key]) {
    								$scope.form[key].$error.notFound = true;    							
    							} else {
    								$scope.form.$error[key] = val;
    							}
    						});
    					} else {
    						$scope.transferComplete = true;
    					}
    					$scope.$apply();
    				},
    				error: function(data) {
    					$.each(data.responseJSON.errors, function(idx, el) {
    						$scope.form[el.field].$error.pattern = true;
    					});
    					console.log($scope.form);
    					$scope.$apply();
    				}
    			});
    		}
    	};   
    	return {
            restrict : "E",
            templateUrl : "../modules/transferModule.html",
            controller: transferController,
            controllerAs: "TransferController"
        };
    });

}());