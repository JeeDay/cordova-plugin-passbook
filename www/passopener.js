var passopener = exports;

var exec = require('cordova/exec');

/**
 * Pass
 *
 * @param {string} passTypeIdentifier
 * @param {string} serialNumber {string}
 * @param {string} passURL
 * @constructor
 */
var Pass = function (passTypeIdentifier, serialNumber, passURL) {
    this.passTypeIdentifier = passTypeIdentifier || null;
    this.serialNumber = serialNumber || null;
    this.passURL = passURL || null;
};


Pass.prototype.open = function () {
    passopener.openPass(this.passURL, null, null);
};

passopener.Pass = Pass;

/**
 *
 * @param resultCallback {Function} is called with result
 */
passopener.available = function (resultCallback) {
    exec(resultCallback, null, "PassOpener", "available", []);
};
/**
 *
 * @param {Object}  url:String | { url:String, headers?:Object }
 * @param {Function} passCallback
 * @param {Function} errorCallback
 */
passopener.downloadPass = function (callData, passCallback, errorCallback) {
    exec(function (result) {
        if (typeof(passCallback) === 'function') {
            var pass = result.pass;
            passCallback(new Pass(pass.passTypeIdentifier, pass.serialNumber, pass.passURL), result.added);
        }
    }, errorCallback, "PassOpener", "downloadPass", [callData]);
};

/**
 *
 * @param file Local File URL, e.g. file:///path/pass.pkpass
 * @param {Function} passCallback
 * @param {Function} errorCallback
 */
passopener.addPass = function (file, passCallback, errorCallback) {
    exec(function (result) {
        if (typeof(passCallback) === 'function') {
            var pass = result.pass;
            passCallback(new Pass(pass.passTypeIdentifier, pass.serialNumber, pass.passURL), result.added);
        }
    }, errorCallback, "PassOpener", "addPass", [file]);
};

/**
 *
 * @param {Pass|string} passOrUrl
 * @param {Function} successCallback
 * @param {Function} errorCallback
 */
passopener.openPass = function (passOrUrl, successCallback, errorCallback) {
    exec(successCallback, errorCallback, "PassOpener", "openPass", [passOrUrl]);
};
