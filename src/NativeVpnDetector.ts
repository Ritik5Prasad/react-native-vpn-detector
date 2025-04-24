import type {TurboModule} from 'react-native';
import {TurboModuleRegistry} from 'react-native';

export interface Spec extends TurboModule {
  isProxyEnabled(callback: (result: string) => void): void;
  isVPNEnabled(callback: (result: string) => void): void;
}

export default TurboModuleRegistry.getEnforcing<Spec>('VpnDetector');
