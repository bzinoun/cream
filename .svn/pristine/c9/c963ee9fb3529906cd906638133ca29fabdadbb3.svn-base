'use strict';

angular.module('creamApp')
    .controller('CompagneDetailController', function ($scope, $rootScope, $stateParams, entity, Compagne, Prospection, RefStatutCompagne) {
        
        var getPourcentage = function (partiel , total){
        	
        	return  (100 * partiel / total ).toFixed(2); 
        	
        }
        
        
        
        
    	$scope.compagne = entity;
        $scope.load = function (id) {
            Compagne.get({id: id}, function(result) {
                $scope.compagne = result;
            });
        };
        
        
        $scope.countClient = 0 ; 
        $scope.countProspect =  $scope.compagne.personnes.length ; 
        $scope.countPersonne =  $scope.compagne.personnes.length ; 
        $scope.labels = ["Prospect", "Client"];
        
        $scope.compagne.personnes.forEach(function(personne){
        	if(personne.client)
        		 $scope.countClient =  $scope.countClient + 1 ; 
        });
        
        
        $scope.countProspect = $scope.countProspect  - $scope.countClient ; 
        $scope.data = [$scope.countProspect, $scope.countClient];
        
        $scope.progression = getPourcentage($scope.countClient ,$scope.countPersonne );
        
        var unsubscribe = $rootScope.$on('creamApp:compagneUpdate', function(event, result) {
            $scope.compagne = result;
        });
        $scope.$on('$destroy', unsubscribe);

        
        
        $scope.getPriority = function(){
        	if($scope.progression > 70){    return 'panel-success' ;}
            if($scope.progression < 20){   	return 'panel-danger'}
    
            return 'panel-warning';
        }
        var oneDay = 24*60*60*1000; // hours*minutes*seconds*milliseconds
        var now = new Date();
//debugger ;
        $scope.nombreJourCompagne = Math.round(Math.abs(( $scope.compagne.dateFin.getTime()- $scope.compagne.dateDebut.getTime() )/(oneDay)));
        $scope.nombreJourRestant = Math.round(Math.abs(($scope.compagne.dateFin.getTime()  - now.getTime())/(oneDay)));
        $scope.restCompagne =  getPourcentage( $scope.nombreJourRestant, $scope.nombreJourCompagne);
        $scope.restCompagne = (100 - $scope.restCompagne).toFixed(2) ; 
        console.log('dd');
        
    });
