import unittest
from cassis import *
import dkproFlair


class TestDkproFlair(unittest.TestCase):

    def test_casFlair(self):
        sentence = "Obama was born in Honolulu , Hawaii , making him the first president not born in the contiguous United States . After graduating from Columbia University in 1983 , he worked as a community organizer in Chicago ."
        cas = Cas(typesystem=load_dkpro_core_typesystem())
        cas.sofa_string = sentence
        NERType = cas.typesystem.get_type(
            "de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity")

        tokens = [
            NERType(begin="0", end="6", value="person"),
            NERType(begin="18", end="26", value="location"),
            NERType(begin="29", end="35", value="location"),
            NERType(begin="96", end="109", value="location"),
            NERType(begin="134", end="153", value="organization"),
            NERType(begin="202", end="209", value="location"),
        ]

        for token in tokens:
            cas.add_annotation(token)

        # actual_tokens = list(cas.select(NERType.name))

        # Test
        result = dkproFlair.casFlair(sentence)
        self.assertEqual(result, cas)
