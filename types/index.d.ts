// Type definitions for Apache Cordova Network Information plugin
// Project: https://github.com/jeeday/cordova-plugin-passopener
// Definitions by: Microsoft Open Technologies Inc <http://msopentech.com>
// Definitions: https://github.com/DefinitelyTyped/DefinitelyTyped
// 
// Copyright (c) Microsoft Open Technologies Inc
// Licensed under the MIT license

interface PassOpener {
	open: () => void;
	available: (resultCallback: () => any) => void;
	downloadPass: (callData: any, passCallback, errorCallback: () => any) => void;
	addPass: (file: any, passCallback, errorCallback: () => any) => void;
	openPass: (passOrUrl: any, passCallback, errorCallback: () => any) => void;
}