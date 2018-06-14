package ayds.dictionary.foxtrot.model.externalServices.adapters;import ayds.dictionary.delta.services.BigHugeLabsService;import ayds.dictionary.foxtrot.model.externalServices.Source;import ayds.dictionary.foxtrot.services.YandexService;import wikipedia.service.WikipediaService;import java.util.HashMap;import java.util.Map;public class ServiceMapFactoryImpl implements ServicesMapFactory {    private Map<Source, ServiceAdapter> servicesMap;    ServiceMapFactoryImpl(YandexService yandexService, WikipediaService wikipediaService, BigHugeLabsService gigHugeLabsService){        servicesMap =  new HashMap<Source, ServiceAdapter>();        servicesMap.put(Source.YANDEX, new YandexServiceAdapter(yandexService));        servicesMap.put(Source.WIKIPEDIA, new WikipediaServiceAdapter(wikipediaService));        servicesMap.put(Source.BHLLIB, new BigHugeLabsAdapter(gigHugeLabsService));    }    public Map<Source, ServiceAdapter> getServicesMap(){        return servicesMap;    }}