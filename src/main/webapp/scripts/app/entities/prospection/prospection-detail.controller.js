'use strict';

angular.module('creamApp')
    .controller('ProspectionDetailController', function ($scope, $rootScope, $stateParams, entity, Prospection, Personne, Compagne, Tache, RefStatutProspection) {

    	$scope.prospection = entity;
        $scope.load = function (id) {
            Prospection.get({id: id}, function(result) {
                $scope.prospection = result;
                $scope.personne = Personne.get({id: result.personneId});
            })
        };
       
        
        $scope.personne = Personne.get({id: $scope.prospection.personneId});
        $scope.compagne = Compagne.get({id: $scope.prospection.compagneId});
        
        
        //get tache if exist
        if($stateParams.tacheId ){
        	$scope.tache =  Tache.get({id:$stateParams.tacheId });
        }
        
        
        
        
        
        var unsubscribe = $rootScope.$on('creamApp:prospectionUpdate', function(event, result) {
            $scope.prospection = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
