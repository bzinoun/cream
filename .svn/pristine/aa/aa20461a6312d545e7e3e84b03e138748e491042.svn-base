'use strict';

angular.module('creamApp')
    .directive('activeMenu', function($translate, $locale, tmhDynamicLocale) {
        return {
            restrict: 'A',
            link: function (scope, element, attrs) {
                var language = attrs.activeMenu;

                scope.$watch(function() {
                    return $translate.use();
                }, function(selectedLanguage) {
                    if (language === selectedLanguage) {
                        tmhDynamicLocale.set(language);
                        element.addClass('active');
                    } else {
                        element.removeClass('active');
                    }
                });
            }
        };
    })
    .directive('activeLink', function(location) {
        return {
            restrict: 'A',
            link: function (scope, element, attrs) {
                var clazz = attrs.activeLink;
                var path = attrs.href;
                path = path.substring(1); //hack because path does bot return including hashbang
                scope.location = location;
                scope.$watch('location.path()', function(newPath) {
                    if (path === newPath) {
                        element.addClass(clazz);
                    } else {
                        element.removeClass(clazz);
                    }
                });
            }
        };
    });
angular.module('creamApp').directive('mfbMenu', [function(){
    return {
      restrict: 'EA',
      transclude: true,
      replace: true,
      scope: {
        position: '@',
        effect: '@',
        label: '@',
        link:'@',
        resting: '@restingIcon',
        active: '@activeIcon'      
      },
      template: '<ul class="mfb-component--{{position}} mfb-{{effect}}">' +
                ' <li class="mfb-component__wrap">' +
                '  <a ui-sref ="{{link}}" data-mfb-label="{{label}}" class="mfb-component__button--main">' +
                '   <i class="mfb-component__main-icon--resting {{resting}}"></i>' +
                '   <i class="mfb-component__main-icon--active {{active}}"></i>' +              
                '  </a>' +
                '  <ul class="mfb-component__list" ng-transclude>' +
                '  </ul>' +
                ' </li>' +        
                '</ul>'              
    };
  }]);


  angular.module('creamApp').directive('mfbButton', [function(){
    return {
      require: '^mfbMenu',
      restrict: 'EA',
      transclude: true,  
      replace: true,
      scope: {
        icon: '@',
        label: '@',
        link:'@'
      },
      template: '<li>' + 
                ' <a data-mfb-label="{{label}}" class="mfb-component__button--child"  ui-sref="{{link}}">' +
                '   <i class="mfb-component__child-icon {{icon}}"' +
                '   </i>' +
                ' </a>' +
                '</li>'
    };
  }]);