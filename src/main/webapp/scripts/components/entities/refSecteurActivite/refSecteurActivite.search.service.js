'use strict';

angular.module('creamApp')
    .factory('RefSecteurActiviteSearch', function ($resource) {
        return $resource('api/_search/refSecteurActivites/:query', {}, {
            'query': { method: 'GET', isArray: true}
        });
    });
