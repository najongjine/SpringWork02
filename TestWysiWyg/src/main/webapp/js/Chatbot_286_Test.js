  window.lattePluginSetting = {
    "master_uid": "bc59d5bb87ce419c9c9ea12a83ca62aa",
      "chatbot_uid": "24df6da06fb648979a6dac3ee9eaa17a",
      "origin_uid": "24df6da06fb648979a6dac3ee9eaa17a"
  };
  (function() {
    if (window.LatteAI) {
      return (window.console.error || window.console.log || function(){})('LatteAI script included twice.');
    }
    var LatteAI = function() {
      LatteAI.c(arguments);
    };
    LatteAI.q = [];
    LatteAI.c = function(args) {
      LatteAI.q.push(args);
    };
    window.LatteAI = LatteAI;

    var loadScript = function() {
      if (window.latteInitialized) {
        return;
      }
      window.latteInitialized = true;
      var scriptTag = document.createElement("script");
      scriptTag.type = "text/javascript";
      scriptTag.async = true;
      scriptTag.src = "https://widget.latte.ai/main.js";
      scriptTag.charset = "UTF-8";
      var firstScriptTag = document.getElementsByTagName('script')[0];
      firstScriptTag.parentNode.insertBefore(scriptTag, firstScriptTag);
    }
    if (document.readyState === 'complete') {
      loadScript();
    } else if (window.attachEvent) {
      window.attachEvent('onload', loadScript);
    } else {
      window.addEventListener('DOMContentLoaded', loadScript, false);
      window.addEventListener('load', loadScript, false);
    }
  })();
