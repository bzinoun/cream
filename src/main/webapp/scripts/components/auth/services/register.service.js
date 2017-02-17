'use strict';

angular.module('creamApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


