'use strict';

angular.module('creamApp')
    .controller('NavbarController', function ($scope, $location, $state, Auth, Principal, ENV ) {
        $scope.isAuthenticated = Principal.isAuthenticated;
        $scope.$state = $state;
        $scope.inProduction = ENV === 'prod';

        $scope.logout = function () {
            Auth.logout();
            $state.go('home');
        };
        $scope.positions = ['br'];

        $scope.effects = [{
          name: 'Choose an effect here',
        },{
          value: 'slidein',
          name: 'Slide in + fade'
        },{
          value: 'zoomin',
          name: 'Zoom in'
        },{
          value: 'fountain',
          name: 'Fountain'
        }];

        $scope.buttons = [{
        	label: 'Recherche',
            icon: 'fa fa-search',
            link: 'personne'
        },{
          label: 'Taches',
          icon: 'fa fa-tasks',
          link : 'tache'
        },
    {
    	label: 'Compagne',
    	icon: 'fa fa-tag',
    	link : 'compagne'
    },
        {
        label: 'Prospect',
        icon: 'fa fa-child',
        link : 'prospection'
    }
]
        $scope.chosenEffect = 'slidein';
    });
