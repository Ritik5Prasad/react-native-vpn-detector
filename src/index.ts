import VpnDetector from './NativeVpnDetector';

export const isProxyEnabled = VpnDetector.isProxyEnabled;
export const isVPNEnabled = VpnDetector.isVPNEnabled;

export default {
  isProxyEnabled,
  isVPNEnabled,
};
