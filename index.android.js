'use strict';

var React = require('react-native');
var ImageView = require('./ImageView.js');
var TouchableImageView = require('./TouchableImageView.js');
var {
  Text,
  View,
  Image,
  ToastAndroid,
} = React;


class ReactNativeExample extends React.Component {
  alerthaha () {
    ToastAndroid.show('Awesome', ToastAndroid.SHORT);
  }
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.hello}>Hello, World</Text>
        <ImageView src= "http://i.imgur.com/UePbdph.jpg" resizeMode = "stretch" style = {styles.thumbnail}/>
        <TouchableImageView src= "http://i.imgur.com/UePbdph.jpg" resizeMode = "stretch" style = {styles.thumbnail}
            onChange={this.alerthaha}/>
      </View>
    )
  }
}
var styles = React.StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  thumbnail: {
    width:53,
    height:81,
  },
});


React.AppRegistry.registerComponent('ReactNativeExample', () => ReactNativeExample);
