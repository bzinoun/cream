'use strict';

angular.module('creamApp')
    .factory('TacheSearch', function ($resource) {
        return $resource('api/_search/taches/:query', {}, {
            'query': { method: 'GET', isArray: true}
        });
    });
