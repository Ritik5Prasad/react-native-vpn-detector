import React, {useEffect, useState} from 'react';
import {Text, View, StyleSheet} from 'react-native';
import * as VpnDetector from 'react-native-vpn-detector';

export default function App() {
  const [isVpnEnabled, setisVpnEnabled] = useState(false);
  const [isProxyEnabled, setIsProxyEnabled] = useState(false);

  useEffect(() => {
    VpnDetector.isVPNEnabled(result => {
      console.log('VPN Enabled:', result);
      setisVpnEnabled(result == 'YES');
    });

    VpnDetector.isProxyEnabled(result => {
      console.log('Proxy Enabled:', result);
      setIsProxyEnabled(result == 'YES');
    });
  }, []);

  return (
    <View style={styles.container}>
      <Text style={styles.text}>
        Check console for VPN/Proxy Detection result!
      </Text>

      {(isVpnEnabled || isProxyEnabled) && (
        <View style={styles.warningBox}>
          <Text style={styles.warningText}>
            ⚠️ {isVpnEnabled ? 'VPN is enabled. ' : ''}
            {isProxyEnabled ? 'Proxy is enabled.' : ''}
          </Text>
        </View>
      )}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    padding: 16,
  },
  text: {
    fontSize: 16,
    marginBottom: 20,
  },
  warningBox: {
    backgroundColor: '#ffe0e0',
    padding: 10,
    borderRadius: 8,
    borderWidth: 1,
    borderColor: '#ff4d4d',
  },
  warningText: {
    color: '#d8000c',
    fontWeight: 'bold',
    fontSize: 16,
  },
});
