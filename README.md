# com.jeeday.passbook

This plugin provides support for showing Passbook passs to your users and allows them to add it to their native Wallet (regardless of how you create your passes, whether you do it on your own or using any third-party services)

**NOTE**: This plugin does not allow you to create Passbook passes.

## Installation

    cordova plugin add cordova-plugin-passopener

Or the latest (unstable) version:

    cordova plugin add https://github.com/jeeday/cordova-plugin-passopener

## Supported Platforms


- iOS
- Android

## Example

### Simple Call

```javascript
    PassOpener.downloadPass('https://d.pslot.io/cQY2f', function (pass, added) {
        console.log(pass, added);
        if (added) {
            Passbook.openPass(pass);
        } else {
            alert('Please add the pass');
        }
    }, function (error) {
        console.error(error);
    });
```

### Adding Headers

```javascript

   var callData =  {
                    "url":'https://d.pslot.io/cQY2f',
                    "headers":{ "authorization": "Bearer <token>" }
                  };

    PassOpener.downloadPass(callData, function (pass, added) {
        console.log(pass, added);
        if (added) {
            Passbook.openPass(pass);
        } else {
            alert('Please add the pass');
        }
    }, function (error) {
        console.error(error);
    });
```

## Documentation

Plugin documentation: [doc/index.md](doc/index.md)


## Creating Passbook Passes
This Plugin is a fork of PassSlot's plugin visible here -> https://github.com/passslot/cordova-plugin-passbook.<br>
PassSlot is a Passbook service that makes Passbook usage easy for everybody. It helps you design and distribute mobile passes to all major mobile platforms.
