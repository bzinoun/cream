'use strict';

angular.module('creamApp')
	.controller('TacheCloseController', function($scope, $uibModalInstance, entity, Tache) {

        $scope.tache = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        
        
        var onSaveSuccess = function (result) {
            $scope.$emit('creamApp:tacheUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.tache.id != null) {
                Tache.update($scope.tache, onSaveSuccess, onSaveError);
            } else {
                Tache.save($scope.tache, onSaveSuccess, onSaveError);
            }
        };
        
        $scope.confirmClose = function (tache) {
        	//etat Terminé -> 5 
        	$scope.tache.statutTacheId = "5";
        	$scope.save();
        }
    });
