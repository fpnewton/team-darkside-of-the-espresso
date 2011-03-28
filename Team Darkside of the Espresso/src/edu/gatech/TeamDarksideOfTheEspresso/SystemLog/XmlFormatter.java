package edu.gatech.TeamDarksideOfTheEspresso.SystemLog;


public class XmlFormatter
{
        public static String FormatData(String Key, String Value)
        {
                StringBuffer temp = new StringBuffer();
                
                temp.append("\t<" + Key + ">");
                temp.append(Value);
                temp.append("</" + Key + ">\n");
                
                return temp.toString();
        }
        
        
        public static String getHead(String Value)
        {
                return "<" + Value + ">\n";
        }
        
        
        public static String getTail(String Value)
        {
                return "</" + Value + ">\n\n";
        }
        
        
        public static String getXmlIDTag()
        {
                return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n\n";
        }
}

