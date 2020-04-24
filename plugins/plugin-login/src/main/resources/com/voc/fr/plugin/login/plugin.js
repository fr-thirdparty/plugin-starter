// var Copyright = BI.inherit(BI.Widget, {})
// BI.shortcut('dec.login.copyright', Copyright)

// 定义组件
var Login = BI.inherit(BI.Widget, {

  props: {
    baseCls: 'dec-login'
  },

  _store: function () {
    return BI.Models.getModel('dec.model.login')
  },

  watch: {},

  render: function () {
    var self = this, loginConfig = this.model.loginConfig

    // 调用自定义主题色，可以自行配置
    BI.Services.getService('dec.service.login').initStyles()

    return {
      type: 'bi.absolute',
      cls: 'dec-login-fresh',
      items: [{
        el: {
          type: 'bi.img',
          width: '65%',
          src: Dec.fineServletURL + '/resources?path=com/voc/fr/plugin/login/images/theme.png'
        }, top: 0, left: 0, bottom: 0
      }, {
        el: {
          type: 'bi.center_adapt',
          width: '23%',
          cls: 'login-area',
          items: [{
            type: 'bi.absolute',
            cls: 'edit-area',
            height: 440,
            width: '100%',
            items: [{
              el: {
                type: 'bi.horizontal_auto',
                height: 100,
                items: [{
                  el: {
                    type: 'bi.center_adapt',
                    items: [{
                      type: 'bi.img',
                      src: BI.isEmpty(loginConfig.loginLogoImgId) ?
                        (Dec.resourceURL + 'resources/logo_FR.png') : (Dec.fineServletURL + '/login/image/' + loginConfig.loginLogoImgId),
                      height: 72,
                      width: 'auto'
                    }]
                  }
                }, {
                  el: {
                    type: 'bi.label',
                    height: 24,
                    cls: 'dec-login-visual-title',
                    text: loginConfig.loginTitle
                  },
                  tgap: 16
                }],
                ref: function (_ref) {
                  self.logo = _ref
                }
              }, top: 30, right: 0, left: 0
            }, {
              el: {
                type: 'dec.login.index',
                listeners: [{
                  eventName: 'EVENT_CHANGE',
                  action: function (v) {
                    self.logo.setVisible(v === DecCst.Login.Tabs.LOGIN)
                  }
                }]
              }, top: 110, right: 0, bottom: 0, left: 0
            }]
          }]
        }, top: 0, right: '10%', bottom: 0
      }, {
        el: {
          type: 'bi.center_adapt',
          cls: 'copyright',
          items: [{
            type: 'bi.label',
            text: '主办单位：海南省民政厅  技术支持：安徽晶奇网络科技股份有限公司 服务热线：0551-65350880、65350890、4006513766'
          }],
          invisible: !loginConfig['copyrightInfoDisplay'],
          bottom: 12
        }
      }],
      ref: function (_ref) {
        self.loginBg = _ref
      }

    }
  },

  mounted: function () {
    var loginConfig = this.model.loginConfig
    // 使用用户自定义登录
    if (loginConfig.loginImg) {
      this.loginBg.element.css('backgroundImage', 'url(' + Dec.fineServletURL + '/login/image/' + loginConfig.loginImgId + ')')
    }
  }
})
// 注册组件
BI.shortcut('dec.login.visual', Login)

BI.config('dec.login', function (ob) {
  return BI.extend(ob, { type: 'dec.login.visual' })
})

