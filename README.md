# react-native-vpn-detector-latest

This Library used to detect vpn

## Installation

```sh
npm install react-native-vpn-detector-latest
```

## Usage

```
import * as VpnDetector from 'react-native-vpn-detector-latest';

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
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---


