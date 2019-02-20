package rtl.tot.corp.mrex.pctm.price.catalog.mrexpctmpricecatalogcmd.infraestrucure.adapters.http.rest.constants;

public final class RestConstants {

    public static final String ROOT = "rtl.sod.corp.sche.whmg";
    public static final String ENTITY = ".appointment";
    public static final String COUNTRY = "Country";
    public static final String SOURCE = ".source.tag";


	
    public static final String API_PATH                   = "/api";
    public static final String VALIDATE_ERROR             = "Validate_Error";
    public static final String SERVICE_BASE_PACKAGE       = "rtl.sod.corp.sche.whmg.appointment.infraestructure.adapters.http.rest";
    public static final String SYSTEM_ERROR               = "System_Error";
    public static final String SUCCESS_RESPONSE           = "Success_Response";
    public static final int    SUCCESS_CODE               = 0;
    public static final int    ERROR_CODE                 = 1;
    public static final String JMS_FACTORY                = "jms_factory";
    public static final String JMS_TOPIC                  = "jms_topic";
    public static final String JMS_PATH                   = "jms_path";
    public static final String JMS_USER_NAME              = "jms_user_name";
    public static final String JMS_PASSWORD               = "jms_password";
    public static final String JMS_SELECTOR_CODE          = "orderId";
    public static final String JMS_XTXREF                 = "XtxRef";
    public static final String JMS_XCMREF                 = "XcmRef";
    public static final String JMS_XRHSREF                = "XrhsRef";
    public static final String JMS_USRTX                  = "XusrTx";
    public static final String JMS_COUNTRY                = "Xcountry";
    public static final String JMS_COMMERCE               = "Xcommerce";
    public static final String UPDATE_ORDER_ACTION        = "updateOrder";
    public static final String CANCEL_ORDER_ACTION        = "cancelOrder";
    public static final String FREE_MARKER_TEMPLATE_PATH = "templatePath";
    public static final String CANCEL_ORDER_TEMPLATE_FILE = "cancelOrderTemplate";
    public static final String UPDATE_ORDER_TEMPLATE_FILE = "updateOrderTemplate";

    public static final String TRANSACTION_REF_HEADER     = "X-txRef";
    public static final String CONSUMER_REF_HEADER        = "X-cmRef";
    public static final String NODE_REF_HEADER            = "X-nodeRef";

    public static final String TRANSACTION_REF_MDC        = "txRef";
    public static final String CONSUMER_REF_MDC           = "cmRef";
    public static final String NODE_REF_MDC               = "nodeRef";
    public static final String SERVICE_REF_MDC            = "srvRef";


	private RestConstants() {

	}
}
