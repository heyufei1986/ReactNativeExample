// ImageView.js
'use strict';

var { requireNativeComponent, PropTypes } = require('react-native');

var iface = {
  name: 'ImageView',
  propTypes: {
    src: PropTypes.string,
    resizeMode: PropTypes.oneOf(['cover', 'contain', 'stretch']),
  },
};


module.exports = requireNativeComponent('RCTImageView', iface, {nativeOnly:{
  'scaleX': true,
  'scaleY': true,
  'testID': true,
  'decomposedMatrix': true,
  'backgroundColor': true,
  'accessibilityComponentType': true,
  'renderToHardwareTextureAndroid': true,
  'translateY': true,
  'translateX': true,
  'accessibilityLabel': true,
  'accessibilityLiveRegion': true,
  'importantForAccessibility': true,
  'rotation': true,
  'opacity': true,
}});
