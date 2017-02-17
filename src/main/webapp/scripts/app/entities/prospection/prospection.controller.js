'use strict';
angular.module('creamApp').factory('Qualif', function ($resource, DateUtils) {
	return $resource('/api/prospections/a_qualifie', {}, {
		'query': { method: 'GET', isArray: true}
		
	});
});
angular.module('creamApp')
    .controller('ProspectionController', function ($scope, $state,$stateParams, Prospection ,Qualif, ProspectionSearch, ParseLinks ) {
        $scope.prospections = [];
        $scope.prospectionsAqualifie = [];
        $scope.predicate = 'id';
        $scope.reverse = true;
        $scope.page = 1;
        $scope.loadAll = function() {
            Prospection.query({page: $scope.page - 1, size: 20, sort: [$scope.predicate + ',' + ($scope.reverse ? 'asc' : 'desc'), 'id']}, function(result, headers) {
                $scope.links = ParseLinks.parse(headers('link'));
                $scope.totalItems = headers('X-Total-Count');
                $scope.prospections = result;
            });
        };
        $scope.loadPage = function(page) {
            $scope.page = page;
            $scope.loadAll();
        };
        $scope.loadAll();


        
        
        $scope.loadAllAqualifie = function() {
        	Qualif.query({page: $scope.page - 1, size: 20, sort: [$scope.predicate + ',' + ($scope.reverse ? 'asc' : 'desc'), 'id']}, function(result, headers) {
                $scope.links = ParseLinks.parse(headers('link'));
                $scope.totalItemsAqualifie = headers('X-Total-Count');
                $scope.prospectionsAqualifie = result;
            });
        };
        $scope.loadPageAqualifie = function(page) {
            $scope.page = page;
            $scope.loadAll();
        };
        $scope.loadAllAqualifie();
        
        
        $scope.search = function () {
            ProspectionSearch.query({query: $scope.searchQuery}, function(result) {
                $scope.prospections = result;
            }, function(response) {
                if(response.status === 404) {
                    $scope.loadAll();
                }
            });
        };

        $scope.refresh = function () {
            $scope.loadAll();
            $scope.clear();
        };
        $scope.getLabelClass = function (prospection) {

        	
        	if (prospection.statutProspectionLibelle != 'Términé') {
    			return "label-success"
			}
			return "label-warning";
        };

        $scope.clear = function () {
            $scope.prospection = {
                sujet: null,
                description: null,
                dateDebut: null,
                dateFin: null,
                immatriculation: null,
                marque: null,
                modele: null,
                usageLibelle: null,
                codeUsage: null,
                energie: null,
                anneeVignette: null,
                user: null,
                id: null
            };
        };
    });
