'use strict';

angular.module('creamApp')
    .controller('PersonneController', function ($scope, $state, Personne, PersonneSearch, ParseLinks) {

        $scope.personnes = [];
        $scope.predicate = 'id';
        $scope.reverse = true;
        $scope.page = 1;
        $scope.loadAll = function() {
            Personne.query({page: $scope.page - 1, size: 20, sort: [$scope.predicate + ',' + ($scope.reverse ? 'asc' : 'desc'), 'id']}, function(result, headers) {
                $scope.links = ParseLinks.parse(headers('link'));
                $scope.totalItems = headers('X-Total-Count');
                $scope.personnes = result;
            });
        };
        $scope.loadPage = function(page) {
            $scope.page = page;
            $scope.loadAll();
        };
        $scope.loadAll();


        $scope.search = function () {
            PersonneSearch.query({query: $scope.searchQuery}, function(result) {
                $scope.personnes = result;
            }, function(response) {
                if(response.status === 404) {
                	console.log("404 Personnes")
                    $scope.loadAll();
                }
            });
        };

        $scope.refresh = function () {
            $scope.loadAll();
            $scope.clear();
        };

        $scope.clear = function () {
            $scope.personne = {
                nom: null,
                numeroCIN: null,
                rc: null,
                telephone: null,
                prenom: null,
                civilite: null,
                type: null,
                titre: null,
                dateNaissance: null,
                numeroPatente: null,
                raisonSociale: null,
                email: null,
                ville: null,
                dateObtentionPermis: null,
                numeroPermis: null,
                id: null
            };
        };
    });
