'use strict';

angular.module('creamApp')
    .controller('MainController', function ($scope, Principal ,TacheLast) {
        Principal.identity().then(function(account) {
            $scope.account = account;
            $scope.isAuthenticated = Principal.isAuthenticated;
        });
    
    
        $scope.LastTaches = [];
        
        TacheLast.query({nbr:5}, function(result, headers) {
        	$scope.LastTaches = result;
            });
        
        
        // Charts 
        
        $scope.labels1 = ["January", "February", "March", "April", "May", "June", "July"];
        $scope.series1 = ['Series A', 'Series B'];
        $scope.data1 = [
          [65, 59, 80, 81, 56, 55, 40],
          [28, 48, 40, 19, 86, 27, 90]
        ];
        $scope.onClick = function (points, evt) {
          console.log(points, evt);
        };
        
        
        $scope.labels2 = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
        $scope.series2 = ['Series A', 'Series B'];

        $scope.data2 = [
          [65, 59, 80, 81, 56, 55, 40],
          [28, 48, 40, 19, 86, 27, 90]
        ];
        
        $scope.labels3 = ["Download Sales", "In-Store Sales", "Mail-Order Sales"];
        $scope.data3 = [300, 500, 100];
        
        $scope.labels4 =["Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running"];

        $scope.data4 = [
          [65, 59, 90, 81, 56, 55, 40],
          [28, 48, 40, 19, 96, 27, 100]
        ];
        
    });
