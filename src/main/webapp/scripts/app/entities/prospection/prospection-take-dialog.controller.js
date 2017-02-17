'use strict';

angular.module('creamApp')
	.controller('ProspectionTakeController', function($scope, $uibModalInstance, entity, Prospection,Account) {

		var user = {};
		
		Account.get().$promise
        .then(function (account) {
        	user = account.data;
        });
        
        $scope.prospection = entity;
		
		 $scope.load = function(id) {
	            Prospection.get({id : id}, function(result) {
	                $scope.prospection = result;
	            });
	            
		 }
		
		
        var onSaveSuccess = function (result) {
            $scope.$emit('creamApp:prospectionUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
            $uibModalInstance.close(true);
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
            $uibModalInstance.close(true);
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.prospection.id != null) {
                Prospection.update($scope.prospection, onSaveSuccess, onSaveError);
            } else {
                Prospection.save($scope.prospection, onSaveSuccess, onSaveError);
            }
        };
		

		
        
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmAffectation = function () {
        	$scope.prospection.user = user.login
        	$scope.save();
        };

        $scope.confirmUnlock = function () {
        	$scope.prospection.user = null ; 
        	$scope.save();
        };

    });
