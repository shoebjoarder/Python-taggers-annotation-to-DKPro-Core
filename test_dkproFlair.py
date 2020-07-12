import unittest
from cassis import *
import dkproFlair


class TestDkproFlair(unittest.TestCase):

    def test_casFlair(self):
        sentence = "Obama was born in Honolulu , Hawaii , making him the first president not born in the contiguous United States . After graduating from Columbia University in 1983 , he worked as a community organizer in Chicago ."
        expectedCas = Cas(typesystem=load_dkpro_core_typesystem())
        expectedCas.sofa_string = sentence
        expectedCas.sofa_mime = "text"
        NERType = expectedCas.typesystem.get_type(
            "de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity")

        expectedTokens = [
            NERType(begin=0, end=5, value="person"),
            NERType(begin=18, end=26, value="location"),
            NERType(begin=29, end=35, value="location"),
            NERType(begin=96, end=109, value="location"),
            NERType(begin=134, end=153, value="organization"),
            NERType(begin=202, end=209, value="location"),
        ]

        for token in expectedTokens:
            expectedCas.add_annotation(token)

        expectedList = []
        for token in expectedCas.select("de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity"):
            expectedList.append(str(token.begin) + "/" + str(token.end) + "/" + token.value)

        # Test
        testCas = dkproFlair.casFlair(sentence)
        testList = []
        for token in testCas.select("de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity"):
            testList.append(str(token.begin) + "/" + str(token.end) + "/" + token.value)

        self.assertEqual(testList, expectedList)