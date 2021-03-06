# Import libraries
from flair.data import Sentence
from flair.models import SequenceTagger
from cassis import *
import sys
import getopt


def importData(file):
    with open(file, 'r', encoding='utf-8') as file:
        document = file.read().replace('\n', ' ')
    return document


def casFlair(sentence):
    model_name = 'ner'
    cas = Cas(typesystem=load_dkpro_core_typesystem())
    cas.sofa_string = sentence
    cas.sofa_mime = "text"
    sent = Sentence(sentence)
    nlp = SequenceTagger.load(model_name)
    nlp.predict(sent)
    NERType = cas.typesystem.get_type(
        "de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity")
    for span in sent.get_spans('ner'):
        if span.tag == 'PER':
            val = 'person'
        if span.tag == 'LOC':
            val = 'location'
        if span.tag == 'ORG':
            val = "organization"
        if span.tag == 'MISC':
            val = "miscellaneous"
        ner_annotation = NERType(begin=span.start_pos,
                                 end=span.end_pos,
                                 value=val)
        cas.add_annotation(ner_annotation)
    return cas

    #     # Export to xmi file
    #     cas.to_xmi('./output_Flair.xmi', pretty_print=True)
    #     with open('output_Flair.xmi', 'r') as file:
    #         flairXMI = file.read()
    # return flairXMI


# if __name__ == '__main__':
    # data = importData('./data/document.txt')
    # cas = casFlair(data)
    # list = []
    # for token in cas.select("de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity"):
    #     list.append(token)

#     print(list)
