// MyCustomView.js
'use strict';

var React = require('react-native');





class TouchableImageView extends React.Component {
    constructor() {
        super();
        this._onChange = this._onChange.bind(this);
    }
    _onChange(event: Event) {
        if(!this.props.onChangeMessage){
            return;
        }

        this.props.onChangeMessage(event.nativeEvent.message);
    }

    render() {
        return <TouchableImageView onChange = {this._onChange } />;
    }
}


TouchableImageView.propTypes = {
    /*
        Callback that is called continuously when the user is drargging the map.
    */
    onChangeMessage: React.PropTypes.func,
    src: React.PropTypes.string,
    resizeMode: React.PropTypes.oneOf(['cover', 'contain', 'stretch']),
}

module.exports =  React.requireNativeComponent('RCTTouchableImageView', TouchableImageView, {
    nativeOnly: {onChange: true,
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
      'opacity': true
      }
})
